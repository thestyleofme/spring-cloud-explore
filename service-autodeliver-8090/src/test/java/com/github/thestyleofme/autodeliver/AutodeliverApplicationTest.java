package com.github.thestyleofme.autodeliver;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.CollectionUtils;

/**
 * <p>
 * description
 * </p>
 *
 * @author isaac 2020/11/13 1:31
 * @since 1.0.0
 */
@SpringBootTest(classes = AutodeliverApplication8090.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class AutodeliverApplicationTest {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Test
    public void testInstanceMetaData(){
        List<ServiceInstance> instances = discoveryClient.getInstances("service-resume");
        Assert.assertFalse(CollectionUtils.isEmpty(instances));
        for (ServiceInstance instance : instances) {
            System.out.println("==========="+instance);
        }
    }
}
