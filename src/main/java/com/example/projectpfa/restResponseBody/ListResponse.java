package com.example.projectpfa.restResponseBody;

import com.example.projectpfa.restResponse.GenericResponseBody;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListResponse<T extends Object> extends GenericResponseBody {
    private List<T> list;
}
