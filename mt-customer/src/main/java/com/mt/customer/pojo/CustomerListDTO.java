package com.mt.customer.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class CustomerListDTO {
    @ApiModelProperty(name="customerId",value="xxxx",example="examle1111")
    public String customerId;
    @ApiModelProperty(name="customerName",value="xxxx2",example="examle11211")
    public String customerName;
    @ApiModelProperty(name="phone",value="xxxx",example="15811111111")
    public String phone;
    @ApiModelProperty(name="email",value="xxxx",example="xxx@xxx.xxx")
    public String email;
    @ApiModelProperty(name="permission",value="xxxx",example="xxx")
    public String permission;

    @Override
    public String toString() {
        return "CustomerListDTO{" +
                "customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", permission='" + permission + '\'' +
                '}';
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
