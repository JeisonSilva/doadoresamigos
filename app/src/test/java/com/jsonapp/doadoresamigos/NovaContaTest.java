package com.jsonapp.doadoresamigos;


import com.jsonapp.doadoresamigos.autenticacao.ContaDto;
import com.jsonapp.doadoresamigos.autenticacao.NovaConta;
import com.jsonapp.doadoresamigos.autenticacao.NovaContaDal;
import com.jsonapp.doadoresamigos.autenticacao.NovaContaRepositorio;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class NovaContaTest {

    @Before
    public void ConfigurarTestes(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void DeveReceberNovaContaDeUsuario(){
        ContaDto contaDto = new ContaDto();
        contaDto.setUsuario("leandro");
        contaDto.setSenha("123456");
        contaDto.setConfirmacaoSenha("123456");
        NovaContaDal novaContaDal = Mockito.mock(NovaContaDal.class);
        NovaContaRepositorio novaContaRepositorio = Mockito.mock(NovaContaRepositorio.class);
        NovaConta novaConta = new NovaConta(novaContaDal, novaContaRepositorio);
        when(novaContaDal.obterDadosDaConta()).thenReturn(contaDto);

        novaConta.criarNovoUsuario();

        verify(novaContaRepositorio).registrar(Mockito.any(ContaDto.class));
    }

    @Test
    public void DeveNotificarPreenchimentoDoUsuario(){
        ContaDto contaDto = new ContaDto();
        contaDto.setSenha("123456");
        contaDto.setConfirmacaoSenha("123456");
        NovaContaDal novaContaDal = Mockito.mock(NovaContaDal.class);
        NovaContaRepositorio novaContaRepositorio = Mockito.mock(NovaContaRepositorio.class);
        NovaConta novaConta = new NovaConta(novaContaDal, novaContaRepositorio);

        when(novaContaDal.obterDadosDaConta()).thenReturn(contaDto);
        novaConta.criarNovoUsuario();

        verify(novaContaDal).notificarPreenchimentoUsuario();
    }

    @Test
    public void DeveNotiticarPreenchimentoDeSenha(){
        ContaDto contaDto = new ContaDto();
        contaDto.setUsuario("leandro");
        contaDto.setConfirmacaoSenha("123456");
        NovaContaDal novaContaDal = Mockito.mock(NovaContaDal.class);
        NovaContaRepositorio novaContaRepositorio = Mockito.mock(NovaContaRepositorio.class);
        NovaConta novaConta = new NovaConta(novaContaDal, novaContaRepositorio);

        when(novaContaDal.obterDadosDaConta()).thenReturn(contaDto);
        novaConta.criarNovoUsuario();


        verify(novaContaDal).notificarPreenchimentoUsuario();
    }

    @Test
    public  void DeveNotificarPreenchimentoConfirmacaoSenha(){
        ContaDto contaDto = new ContaDto();
        contaDto.setUsuario("leandro");
        contaDto.setSenha("123456");
        NovaContaDal novaContaDal = Mockito.mock(NovaContaDal.class);
        NovaContaRepositorio novaContaRepositorio = Mockito.mock(NovaContaRepositorio.class);
        NovaConta novaConta = new NovaConta(novaContaDal, novaContaRepositorio);

        when(novaContaDal.obterDadosDaConta()).thenReturn(contaDto);
        novaConta.criarNovoUsuario();

        verify(novaContaDal).notificarPreenchimentoSenha();
    }
}
