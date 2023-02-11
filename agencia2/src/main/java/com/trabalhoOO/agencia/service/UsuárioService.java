package com.trabalhoOO.agencia.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.trabalhoOO.agencia.dto.UsuárioLoginDTO;
import com.trabalhoOO.agencia.model.PessoaFísica;
import com.trabalhoOO.agencia.model.PessoaJurídica;
import com.trabalhoOO.agencia.model.Usuário;
import com.trabalhoOO.agencia.repository.PessoaFísicaRepository;
import com.trabalhoOO.agencia.repository.PessoaJurídicaRepository;
import com.trabalhoOO.agencia.repository.UsuárioRepository;

@Service
public class UsuárioService {
	
	@Autowired
	private PessoaFísicaRepository pessoaFísicaRepository;
	
	@Autowired
	private PessoaJurídicaRepository pessoaJurídicaRepository;
	
	@Autowired
	private UsuárioRepository usuárioRepository;
	

	public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    } 
	
	public Optional<Usuário> getUsuárioById(Long id){
		
		return usuárioRepository.findById(id); 
		
	    }
	 
	 
	public PessoaJurídica cadastrarUsuarioPJ (PessoaJurídica pj) {
	       Optional<PessoaJurídica> usuárioPJ = pessoaJurídicaRepository.findByEmail(pj.getEmail());

	        if (usuárioPJ.isPresent()) {
	            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Esse e-mail já está sendo utilizado");
	        } else {
	            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	            pj.setSenha(encoder.encode(pj.getSenha()));

	            PessoaJurídica novoUsuárioPJ = new PessoaJurídica();
	            		
	            novoUsuárioPJ.setNome(pj.getNome());
	            novoUsuárioPJ.setEmail(pj.getEmail());
	            novoUsuárioPJ.setSenha(pj.getSenha());
	            novoUsuárioPJ.setEndereço(pj.getEndereço());
	            novoUsuárioPJ.setCEP(pj.getCEP());
	            novoUsuárioPJ.setContato(pj.getContato());
	            novoUsuárioPJ.setCNPJ(pj.getCNPJ());

	            return pessoaJurídicaRepository.save(novoUsuárioPJ);
	        }
	    }
	
	public PessoaFísica cadastrarUsuarioPF (PessoaFísica pf) {
	       Optional<PessoaFísica> usuárioPF = pessoaFísicaRepository.findByEmail(pf.getEmail());

	        if (usuárioPF.isPresent()) {
	            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Esse e-mail já está sendo utilizado");
	        } else {
	            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	            pf.setSenha(encoder.encode(pf.getSenha()));

	            PessoaFísica novoUsuárioPF = new PessoaFísica();
	            		
	            novoUsuárioPF.setNome(pf.getNome());
	            novoUsuárioPF.setEmail(pf.getEmail());
	            novoUsuárioPF.setSenha(pf.getSenha());
	            novoUsuárioPF.setEndereço(pf.getEndereço());
	            novoUsuárioPF.setCEP(pf.getCEP());
	            novoUsuárioPF.setContato(pf.getContato());
	            novoUsuárioPF.setCPF(pf.getCPF());
	            novoUsuárioPF.setNascimento(pf.getNascimento());
	            novoUsuárioPF.setRG(pf.getRG());
	            novoUsuárioPF.setDataRG(pf.getDataRG());
	            novoUsuárioPF.setÓrgaoRG(pf.getÓrgaoRG());
	            
	            return pessoaFísicaRepository.save(novoUsuárioPF);
	        }
	    }
	
	
    
    public Optional<UsuárioLoginDTO> validarCredencial(Optional<UsuárioLoginDTO> usuárioDTO) {
		
    	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    	
		Optional<Usuário> usuário = usuárioRepository.findByEmail(usuárioDTO.get().getEmail());
		
		if(usuário.isPresent()) {
			if(encoder.matches(usuárioDTO.get().getSenha(), usuário.get().getSenha())) {
				String auth = usuárioDTO.get().getEmail() + ":" + usuárioDTO.get().getSenha();
				
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);
				
				usuárioDTO.get().setToken(authHeader);
				usuárioDTO.get().setNome(usuário.get().getNome());
				
				return usuárioDTO;
			}
		}
		
		return null;
	}

}
