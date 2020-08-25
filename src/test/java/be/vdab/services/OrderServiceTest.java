package be.vdab.services;

import be.vdab.domain.Order;
import be.vdab.repositories.OrderRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Captor
    ArgumentCaptor<Order> orderArgumentCaptor;


    @InjectMocks
    private OrderService orderService;


    @Before
    public void setUp() throws Exception {
        when(orderRepository.getOrders())
                .thenReturn(Arrays.asList(new Order("test1" , 50.0)
                        , new Order("test2",90.0)));

    }

    @Test
    public void getOrder() {
        Assert.assertNotNull(orderService.getOrder());
        Assert.assertEquals(2, orderService.getOrder().size());

    }
    @Test
    public void verifyCalledDeleteOnce() {
        orderService.deleteOrder(new Order("test3", 50.0));
        verify(orderRepository,times(1)).deleteOrder(any());
    }
    @Test
    public void checkOrderArgument() {
        orderService.addOrder(new Order("order4", 50.0));
        verify(orderRepository).addOrder(orderArgumentCaptor.capture());
        Assert.assertEquals(32.5, orderArgumentCaptor.getValue().getPrice(), 0);
        Assert.assertFalse(StringUtils.isEmpty(orderArgumentCaptor.getValue().getOrderNumber()));
    }
}