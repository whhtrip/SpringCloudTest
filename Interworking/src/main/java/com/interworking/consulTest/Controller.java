/*
package com.interworking.consulTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Map;

*/
/**
 * @author:WangHongHao
 * @date:19-10-12创建
 * @date：修改
 * @description：
 *//*

@RestController
@RequestMapping("consul")
public class Controller {
    @Autowired
    ConsulDiscoveryClient consulDiscoveryClient;

    @RequestMapping("getAllService")
    public List<ServiceInstance> getALlService() {
        List<ServiceInstance> allInstances = consulDiscoveryClient.getAllInstances();
        int instancesLength = allInstances.size();
        String host = null;
        int port = 0;
        URI url = null;
        String serviceId = null;
        ServiceInstance serviceInstance = null;
        Map<String,String> metaData = null;
        for (int i = 0; i < instancesLength; i++) {
            serviceInstance = allInstances.get(i);
            host = serviceInstance.getHost();
            port = serviceInstance.getPort();
            url = serviceInstance.getUri();
            serviceId = serviceInstance.getServiceId();
            metaData = serviceInstance.getMetadata();
            System.out.println("ip："+host+" 端口："+port);
            System.out.println("网址："+url);
            System.out.println(serviceId);
            System.out.println(metaData);
        }
        return allInstances;
    }
}
*/
