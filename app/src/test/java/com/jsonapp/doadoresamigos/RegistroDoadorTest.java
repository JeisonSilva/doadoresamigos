package com.jsonapp.doadoresamigos;

import com.jsonapp.doadoresamigos.gestaodoadores.DoadorDto;
import com.jsonapp.doadoresamigos.gestaodoadores.DoadorRepositorio;
import com.jsonapp.doadoresamigos.gestaodoadores.RegistroDoador;
import com.jsonapp.doadoresamigos.gestaodoadores.RegistroDoadorDal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RegistroDoadorTest {

    private RegistroDoador registroDoador;
    private RegistroDoadorDal registroDoadorDal;
    private DoadorRepositorio doadorRepositorio;
    private DoadorDto doadorDto;


    @Before
    public void configurarTestes(){

        this.doadorDto = new DoadorDto();
        doadorDto.setNome("Artur");
        doadorDto.setSobrenome("Pietro");
        doadorDto.setIdade(31);
        doadorDto.setFatorRh("Rh+");
        doadorDto.setTipoDeSangue("O");
        doadorDto.setPeso(68);
        doadorDto.setAltura(1.68);

        this.registroDoadorDal = Mockito.mock(RegistroDoadorDal.class);
        this.doadorRepositorio = Mockito.mock(DoadorRepositorio.class);
        this.registroDoador = new RegistroDoador(this.registroDoadorDal, this.doadorRepositorio);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void deveRegistrarDoador(){
        when(this.registroDoadorDal.obterDadosInformadosPeloUsuario()).thenReturn(this.doadorDto);

        this.registroDoador.registrar();

        verify(this.doadorRepositorio).registrar(Mockito.any(DoadorDto.class));
    }



}
