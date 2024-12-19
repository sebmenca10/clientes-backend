package com.example.clientes.service;

import com.example.clientes.model.Cliente;
import com.example.clientes.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private ClienteRepository clienteRepository;

    public ClienteServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllClientes() {
        // Datos simulados
        Cliente cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setName("John Doe");

        Cliente cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setName("Jane Doe");

        // Configuración del mock
        when(clienteRepository.findAll()).thenReturn(List.of(cliente1, cliente2));

        // Llamada al método
        List<Cliente> clientes = clienteService.getAllClientes();

        // Validación
        assertEquals(2, clientes.size());
        assertEquals("John Doe", clientes.get(0).getName());
        verify(clienteRepository, times(1)).findAll();
    }

    @Test
    void testCreateCliente() {
        // Datos simulados
        Cliente cliente = new Cliente();
        cliente.setName("John Doe");

        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

        // Llamada al método
        Cliente result = clienteService.createCliente(cliente);

        // Validación
        assertNotNull(result);
        assertEquals("John Doe", result.getName());
        verify(clienteRepository, times(1)).save(cliente);
    }
}
