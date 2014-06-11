package ex16_4;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface BugsFixed {

}

@BugsFixed
public class Foo {

}
