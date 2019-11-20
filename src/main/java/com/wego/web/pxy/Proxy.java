package com.wego.web.pxy;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("pxy") @Lazy
public class Proxy {
	public String string(Object param) {
		Function<Object, String> f = String :: valueOf;
		return f.apply(param);
	}
	public int integer(String t) {
		Function<String, Integer> f = Integer::parseInt;
		return f.apply(t);
	}
	public boolean equal(String t, String u) {
		BiPredicate<String, String> f = String :: equals;
		return f.test(t, u);
	}
	public void print(String t) {
		Consumer<String> c = System.out::print;
		c.accept(t);
	}
}
