package com.huaxiapawn.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class EvaluationProvider {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		new ClassPathXmlApplicationContext(
				new String[] { "spring-context.xml" }).start();
		com.alibaba.dubbo.container.Main.main(args);
	}
}
