package net.winnerawan.entity;
// Generated Mar 2, 2016 3:00:06 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * DeliveryCost generated by hbm2java
 */
public class DeliveryCost  implements java.io.Serializable {


     private Integer deliveryId;
     private String zoneName;
     private double deliveryCost;
     private Set proOrders = new HashSet(0);

    public DeliveryCost() {
    }

	
    public DeliveryCost(String zoneName, double deliveryCost) {
        this.zoneName = zoneName;
        this.deliveryCost = deliveryCost;
    }
    public DeliveryCost(String zoneName, double deliveryCost, Set proOrders) {
       this.zoneName = zoneName;
       this.deliveryCost = deliveryCost;
       this.proOrders = proOrders;
    }
   
    public Integer getDeliveryId() {
        return this.deliveryId;
    }
    
    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }
    public String getZoneName() {
        return this.zoneName;
    }
    
    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }
    public double getDeliveryCost() {
        return this.deliveryCost;
    }
    
    public void setDeliveryCost(double deliveryCost) {
        this.deliveryCost = deliveryCost;
    }
    public Set getProOrders() {
        return this.proOrders;
    }
    
    public void setProOrders(Set proOrders) {
        this.proOrders = proOrders;
    }




}


