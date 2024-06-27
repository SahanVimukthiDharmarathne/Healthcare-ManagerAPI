/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.exception;

/**
 *
 * @author Sahan Dharmarathna
 */
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String exceptionMessage){
        super(exceptionMessage);
    }
}
