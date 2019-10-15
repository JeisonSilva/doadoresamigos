package com.jsonapp.doadoresamigos;

import com.jsonapp.doadoresamigos.autenticacao.AlteracaoSenha;
import com.jsonapp.doadoresamigos.autenticacao.AlteracaoSenhaDal;
import com.jsonapp.doadoresamigos.autenticacao.ContaDto;
import com.jsonapp.doadoresamigos.autenticacao.ContaRepositorio;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AlteracaoSenhaTest extends ContaBaseTest {

    private AlteracaoSenhaDal alteracaoSenhaDal;
    private ContaRepositorio contaRepositorio;
    private AlteracaoSenha alteracaoSenha;

    @Before
    public void ConfigurarTestes(){
        this.alteracaoSenhaDal = Mockito.mock(AlteracaoSenhaDal.class);
        this.contaRepositorio = Mockito.mock(ContaRepositorio.class);
        this.alteracaoSenha = new AlteracaoSenha(alteracaoSenhaDal, contaRepositorio);


        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void DeveAlterarSenha(){
        ContaDto contaDto = this.configurarConta("Elena", "12345", "12345");
        when(alteracaoSenhaDal.obterDadosContaDigitada()).thenReturn(contaDto);
        when(contaRepositorio.obterConta(Mockito.any(ContaDto.class))).thenReturn(contaDto);

        alteracaoSenha.alterarSenha();

        verify(contaRepositorio).alterar(Mockito.any(ContaDto.class));
    }

    @Test
    public void DeveValidarUsuarioExistente(){
        ContaDto contaDto = this.configurarConta("Elena", "12345", "12345");
        when(alteracaoSenhaDal.obterDadosContaDigitada()).thenReturn(contaDto);
        when(contaRepositorio.obterConta(Mockito.any(ContaDto.class))).thenReturn(contaDto);

        alteracaoSenha.alterarSenha();

        verify(contaRepositorio).obterConta(Mockito.any(ContaDto.class));
        verify(contaRepositorio).alterar(Mockito.any(ContaDto.class));
    }

    @Test
    public void DeveNotificarUsuarioInexistente(){
        ContaDto contaFornecidaPeloUsuario = this.configurarConta("Elena", "12345", "12345");
        ContaDto contaRetornadaDoRepositorio = this.configurarConta("", "", "");
        when(alteracaoSenhaDal.obterDadosContaDigitada()).thenReturn(contaFornecidaPeloUsuario);
        when(contaRepositorio.obterConta(Mockito.any(ContaDto.class))).thenReturn(contaRetornadaDoRepositorio);

        alteracaoSenha.alterarSenha();

        verify(alteracaoSenhaDal).notificarUsuarioInexistente();
    }

    @Test
    public void DeveNotificarConfirmacaoInvalida(){
        ContaDto contaFornecidaPeloUsuario = this.configurarConta("Elena", "12345", "12567");
        ContaDto contaRetornadaDoRepositorio = this.configurarConta("Elena", "12345", "");
        when(alteracaoSenhaDal.obterDadosContaDigitada()).thenReturn(contaFornecidaPeloUsuario);
        when(contaRepositorio.obterConta(Mockito.any(ContaDto.class))).thenReturn(contaRetornadaDoRepositorio);

        alteracaoSenha.alterarSenha();

        verify(alteracaoSenhaDal).notificarConfirmacaoSenhaInvalida();
    }

}
