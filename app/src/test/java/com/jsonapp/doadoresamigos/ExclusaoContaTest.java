package com.jsonapp.doadoresamigos;

import com.jsonapp.doadoresamigos.autenticacao.ContaDto;
import com.jsonapp.doadoresamigos.autenticacao.ContaRepositorio;
import com.jsonapp.doadoresamigos.autenticacao.ExclusaoConta;
import com.jsonapp.doadoresamigos.autenticacao.ExclusaoContaDal;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ExclusaoContaTest {

    private ExclusaoContaDal exclusaoContaDal;
    private ContaRepositorio contaRepositorio;
    private ExclusaoConta exclusaoConta;

    @Before
    public void configurarTestes(){

        this.exclusaoContaDal = Mockito.mock(ExclusaoContaDal.class);
        this.contaRepositorio = Mockito.mock(ContaRepositorio.class);
        this.exclusaoConta = new ExclusaoConta(this.exclusaoContaDal, this.contaRepositorio);

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void DeveExcluirConta(){
        ContaDto contaDto = new ContaDto();
        when(this.exclusaoContaDal.obterDadosConta()).thenReturn(contaDto);

        this.exclusaoConta.excluirConta();

        verify(this.contaRepositorio).excluirConta(Mockito.any(ContaDto.class));
    }

    @Test
    public void DeveRedirecionarParaTelaLoginPosContaExcluida(){
        ContaDto contaDto = new ContaDto();
        when(this.exclusaoContaDal.obterDadosConta()).thenReturn(contaDto);

        this.exclusaoConta.excluirConta();

        verify(this.contaRepositorio).excluirConta(Mockito.any(ContaDto.class));
        verify(this.exclusaoContaDal).encerrarSessao();
    }

}
