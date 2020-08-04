package com.joker.utils;

import android.content.ComponentName;

import com.joker.FixFragmentNavigator;
import com.joker.libcommon.global.AppGlobals;
import com.joker.model.Destination;

import java.util.HashMap;

import androidx.fragment.app.FragmentActivity;
import androidx.navigation.ActivityNavigator;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.NavGraphNavigator;
import androidx.navigation.NavigatorProvider;
import androidx.navigation.fragment.FragmentNavigator;

/**
 * @author Joker
 * @since 2020/08/03
 */
public class NavGraphBuilder {

    public static void build(FragmentActivity activity, NavController controller, int containerId) {
        NavigatorProvider provider = controller.getNavigatorProvider();

        //NavGraphNavigator也是页面路由导航器的一种，只不过他比较特殊。
        //它只为默认的展示页提供导航服务,但真正的跳转还是交给对应的navigator来完成的
        NavGraph navGraph = new NavGraph(new NavGraphNavigator(provider));

//        FragmentNavigator fragmentNavigator = provider.getNavigator(FragmentNavigator.class);
        //fragment的导航此处使用我们定制的FixFragmentNavigator，底部Tab切换时 使用hide()/show(),而不是replace()
        FixFragmentNavigator fragmentNavigator = new FixFragmentNavigator(activity, activity.getSupportFragmentManager(), containerId);
        provider.addNavigator(fragmentNavigator);
        ActivityNavigator activityNavigator = provider.getNavigator(ActivityNavigator.class);
        HashMap<String, Destination> destConfig = AppConfig.getDestConfig();
        for (Destination node : destConfig.values()) {
            if (node.isFragment()) {
                FragmentNavigator.Destination destination = fragmentNavigator.createDestination();
                destination.setId(node.getId());
                destination.setClassName(node.getClassName());
                destination.addDeepLink(node.getPageUrl());
                navGraph.addDestination(destination);
            } else {
                ActivityNavigator.Destination destination = activityNavigator.createDestination();
                destination.setId(node.getId());
                destination.setComponentName(new ComponentName(AppGlobals.getApplication().getPackageName(), node.getClassName()));
                destination.addDeepLink(node.getPageUrl());
                navGraph.addDestination(destination);
            }

            //给APP页面导航结果图 设置一个默认的展示页的id
            if (node.isAsStarter()) {
                navGraph.setStartDestination(node.getId());
            }
        }
        controller.setGraph(navGraph);
    }
}
