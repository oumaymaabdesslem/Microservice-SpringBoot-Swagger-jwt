package com.example.projectpfa.restResponse;

public class ResponseBuilder {

    private static Integer BACK_END_SUCCESS_CODE = 200;



    public static GenericResponse buildSuccessResponse(GenericResponseBody body){
        GenericResponseHeader header = new GenericResponseHeader(BACK_END_SUCCESS_CODE,"");
        GenericResponse response = new GenericResponse();
        response.setBody(body);
        response.setHeader(header);
        return response;
    }

    public static  GenericResponse buildErrorResponse(Integer errorCode,String errorMessage) {

        GenericResponseHeader header = buildResponseHeader(errorCode,errorMessage);
        GenericResponse response = new GenericResponse();
        response.setBody(null);
       response.setHeader(header);
        return response;
    }

    public static GenericResponseHeader buildResponseHeader(Integer statusCode, String errorMessage){
         GenericResponseHeader header = new GenericResponseHeader();
         header.setStatusCode(statusCode);
         header.setErrorMessage(errorMessage);
         return header;
    }
}
