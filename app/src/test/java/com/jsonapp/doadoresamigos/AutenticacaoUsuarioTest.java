package com.jsonapp.doadoresamigos;

import com.jsonapp.doadoresamigos.autenticacao.AutenticacaoDal;
import com.jsonapp.doadoresamigos.autenticacao.AutenticacaoUsuario;
import com.jsonapp.doadoresamigos.autenticacao.ContaDto;
import com.jsonapp.doadoresamigos.autenticacao.ContaRepositorio;
import com.jsonapp.doadoresamigos.autenticacao.NovaContaRepositorio;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AutenticacaoUsuarioTest {

    private AutenticacaoDal autenticacaoDal;
    private ContaRepositorio contaRepositorio;
    private AutenticacaoUsuario autenticacaoUsuario;

    @Before
    public void ConfigurarTestes(){
        this.autenticacaoDal = Mockito.mock(AutenticacaoDal.class);
        this.contaRepositorio = Mockito.mock(ContaRepositorio.class);
        this.autenticacaoUsuario = new AutenticacaoUsuario(this.autenticacaoDal, this.contaRepositorio);

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void DeveAutenticarUsuario(){
        ContaDto contaDto = new ContaDto();
        ContaDto contaDto2 = new ContaDto();
        contaDto.setUsuario("Elena");
        contaDto.setSenha("12345");
        contaDto.setConfirmacaoSenha("12345");
        contaDto2.setUsuario("Elena");
        contaDto2.setSenha("12345");
        when(this.autenticacaoDal.obterDadosUsuario()).thenReturn(contaDto);
        when(this.contaRepositorio.obterConta(Mockito.any(ContaDto.class))).thenReturn(contaDto2);

        this.autenticacaoUsuario.autenticar();

        verify(this.autenticacaoDal).exibirPesquisaDoadores();
    }

    @Test
    public void NaoDeveAutenticarUsuarioInvalido(){
        ContaDto contaDto = new ContaDto();
        ContaDto contaDto2 = new ContaDto();
        contaDto.setUsuario("Elena");
        contaDto.setSenha("12345");
        contaDto.setConfirmacaoSenha("12345");
        contaDto2.setUsuario("");
        when(this.autenticacaoDal.obterDadosUsuario()).thenReturn(contaDto);
        when(this.contaRepositorio.obterConta(Mockito.any(ContaDto.class))).thenReturn(contaDto2);

        this.autenticacaoUsuario.autenticar();

        verify(this.autenticacaoDal).notificarUsuarioInvalido();
    }

    @Test
    public void NaoDeveAutenticarSenhaInvalida(){
        ContaDto contaDto = new ContaDto();
        ContaDto contaDto2 = new ContaDto();
        contaDto.setUsuario("Elena");
        contaDto.setSenha("12345");
        contaDto.setConfirmacaoSenha("12345");
        contaDto2.setUsuario("Elena");
        contaDto2.setSenha("3456");
        when(this.autenticacaoDal.obterDadosUsuario()).thenReturn(contaDto);
        when(this.contaRepositorio.obterConta(Mockito.any(ContaDto.class))).thenReturn(contaDto2);

        this.autenticacaoUsuario.autenticar();

        verify(this.autenticacaoDal).notificarSenhaInvalida();
    }
}
