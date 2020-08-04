package com.joker.libnavannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author Joker
 * @since 2020/08/03
 */
@Target(ElementType.TYPE)
public @interface FragmentDestination {
    String pageUrl();

    boolean needLogin() default false;

    boolean asStarter() default false;
}
