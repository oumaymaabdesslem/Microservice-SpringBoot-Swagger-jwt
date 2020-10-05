package com.example.projectpfa.restResponse;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponse<T extends GenericResponseBody> {
 private GenericResponseBody body;
 private GenericResponseHeader header;
}
