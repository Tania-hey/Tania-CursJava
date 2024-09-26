package ro.itschool.CRUDProject.dtos;

public record ResponsePayload <T> (T data, String message){

}

