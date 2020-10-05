package com.example.projectpfa.restResponseBody;

import com.example.projectpfa.restResponse.GenericResponseBody;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObjectResponse<T> extends GenericResponseBody {
    private T Object;
}
