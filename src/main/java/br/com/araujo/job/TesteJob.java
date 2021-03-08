package br.com.araujo.job;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class TesteJob {
	
	@Scheduled(fixedDelay = 60000)
	public void test() {
		log.warn(" Teste de job: {}", LocalDateTime.now());
	}

}
