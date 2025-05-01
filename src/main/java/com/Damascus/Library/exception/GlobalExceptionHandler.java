//package com.Damascus.Library.exception;
//
//import com.Damascus.Library.dto.response.ErrorResponse;
//import com.Damascus.Library.exception.BadRequest.InvalidRequestException;
//import com.Damascus.Library.exception.BadRequest.ValidationException;
//import com.Damascus.Library.exception.Conflict.*;
//import com.Damascus.Library.exception.Duplicate.DuplicateBorrowingException;
//import com.Damascus.Library.exception.NotFound.*;
//import com.Damascus.Library.exception.Unprocessable.UnprocessableEntityException;
//import jakarta.servlet.http.HttpServletResponse;
//import org.jetbrains.annotations.NotNull;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import java.io.IOException;
//import java.time.LocalDateTime;
//
//@ControllerAdvice
//public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
//
//    @ExceptionHandler({BookNotFoundException.class, PatronNotFoundException.class})
//    public ResponseEntity<ErrorResponse> handleNotFoundException(RuntimeException ex) {
//        return buildErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
//    }
//
//    @ExceptionHandler({
//            DuplicateIsbnException.class,
//            DuplicateEmailException.class,
//            BookNotAvailableException.class,
//            ActiveBorrowingExistsException.class,
//            DuplicateBorrowingException.class
//    })
//    public ResponseEntity<ErrorResponse> handleConflictException(RuntimeException ex) {
//        return buildErrorResponse(HttpStatus.CONFLICT, ex.getMessage());
//    }
//
//    @ExceptionHandler({InvalidRequestException.class, ValidationException.class})
//    public ResponseEntity<ErrorResponse> handleBadRequestException(RuntimeException ex) {
//        return buildErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
//    }
//
//    @ExceptionHandler(UnprocessableEntityException.class)
//    public ResponseEntity<ErrorResponse> handleUnprocessableEntityException(RuntimeException ex) {
//        return buildErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());
//    }
//
//    private ResponseEntity<ErrorResponse> buildErrorResponse(HttpStatus status, String message) {
//        ErrorResponse errorResponse = new ErrorResponse(
//                status.value(),
//                message
//        );
//        return new ResponseEntity<>(errorResponse, status);
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, @NotNull WebRequest request) {
//        String path = request.getDescription(false).replace("uri=", "");
//
//        //ex.printStackTrace();
//
//        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,
//                "An unexpected error occurred: " + ex.getMessage());
//    }
//
//
//}
