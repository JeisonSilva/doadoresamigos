package com.jsonapp.doadoresamigos;

import com.jsonapp.doadoresamigos.gestaodoadores.DoadorDto;
import com.jsonapp.doadoresamigos.gestaodoadores.DoadorRepositorio;
import com.jsonapp.doadoresamigos.gestaodoadores.RegistroDoador;
import com.jsonapp.doadoresamigos.gestaodoadores.DoadorDal;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RegistroDoadorTest {

    private RegistroDoador registroDoador;
    private DoadorDal doadorDal;
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

        this.doadorDal = Mockito.mock(DoadorDal.class);
        this.doadorRepositorio = Mockito.mock(DoadorRepositorio.class);
        this.registroDoador = new RegistroDoador(this.doadorDal, this.doadorRepositorio);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void deveRegistrarDoador(){
        when(this.doadorDal.obterDadosInformadosPeloUsuario()).thenReturn(this.doadorDto);
        when(this.doadorDal.validarPreenchimentoDados()).thenReturn(true);
        this.registroDoador.registrar();

        verify(this.doadorRepositorio).registrar(Mockito.any(DoadorDto.class));
    }



}
