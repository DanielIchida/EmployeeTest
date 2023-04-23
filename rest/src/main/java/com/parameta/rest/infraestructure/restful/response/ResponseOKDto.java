package com.parameta.rest.infraestructure.restful.response;

public class ResponseOKDto extends ResponseDTO
{
     public ResponseDTO drawMessage(Object result) {
         setMessage("OK");
         setType(TypeResponse.SUCCESS);
         setResult(result);
         return this;
     }
}
