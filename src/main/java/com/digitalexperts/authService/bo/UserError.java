package com.digitalexperts.authService.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserError {
    private String errorMessage;
    private String requestPath;
    private String timestamp;
}
