package com.kazale.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import com.kazale.api.entities.Empresa;
import com.kazale.api.repositories.EmpresaRepository;
import com.kazale.api.services.ExemploService;

@SpringBootApplication
@EnableCaching
public class P16Application {
	
	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private ExemploService exemploService;
	
	public static void main(String[] args) {
		SpringApplication.run(P16Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			Empresa empresa = new Empresa();
			empresa.setRazaoSocial("Kazale IT");
			empresa.setCnpj("74645215000104");
			
			this.empresaRepository.save(empresa);

			List<Empresa> empresas = empresaRepository.findAll();
//			empresas.forEach(System.out::println);
//			
//			Empresa empresaDb = empresaRepository.findById(1L).get();
//			System.out.println("Empresa por ID: " + empresaDb);
//			
//			empresaDb.setRazaoSocial("Kazale IT Web");
//			this.empresaRepository.save(empresaDb);
//
//			Empresa empresaCnpj = empresaRepository.findByCnpj("74645215000104");
//			System.out.println("Empresa por CNPJ: " + empresaCnpj);
//			
//			this.empresaRepository.deleteById(1L);
			empresas = empresaRepository.findAll();
			System.out.println("Empresas: " + empresas.size());
			
			System.out.println("Executando serviço pela primeira vez");
			System.out.println(this.exemploService.testarServico());			
			System.out.println("Executando serviço pela segunda vez");
			System.out.println(this.exemploService.testarServico());						
		};
	}
}
