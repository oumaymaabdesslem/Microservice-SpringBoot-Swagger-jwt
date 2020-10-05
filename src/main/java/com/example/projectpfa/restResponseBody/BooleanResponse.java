package com.example.projectpfa.restResponseBody;

import com.example.projectpfa.restResponse.GenericResponseBody;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BooleanResponse extends GenericResponseBody {

    private Boolean response;
}
