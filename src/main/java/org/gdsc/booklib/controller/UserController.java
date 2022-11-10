package org.gdsc.booklib.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.gdsc.booklib.dto.UserDTO;
import org.gdsc.booklib.entities.Users;
import org.gdsc.booklib.payload.ApiResponse;
import org.gdsc.booklib.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Boolean.*;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/gdsc/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    @Operation(
            tags = {"User"},
            operationId = "addUser",
            summary = "add user data",
            description = "to add user data.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "This is the request body for update User request.",
                    content = @Content(schema = @Schema(implementation = Users.class))),
            responses = {@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    content = @Content(
                            schema = @Schema(implementation = Users.class, type = "String"),mediaType = MediaType.APPLICATION_JSON_VALUE),
                    description = "Success Response."),
            }

    )
    public ResponseEntity<ApiResponse> addUser(@RequestBody UserDTO users){
        Users savedUsers = userService.addUser(users);
        ApiResponse apiResponse = new ApiResponse(TRUE, "successfully sign up with id " + savedUsers.getId());
        return new ResponseEntity<>(apiResponse, CREATED);
    }

    @Operation(
            tags = {"User"},
            operationId = "getAllUser",
            summary = "get all user data",
            description = "to fetch all user data",
            responses = {@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    content = @Content(
                            schema = @Schema(implementation = Users.class),mediaType = MediaType.APPLICATION_JSON_VALUE),
                    description = "Success Response."),
            }

    )
    @GetMapping("/getallusers")
    public ResponseEntity<ApiResponse> getAllUser(){
        List<Users> allUsers = userService.getAllUsers();
        ApiResponse apiResponse = new ApiResponse(TRUE, "successfully fetch users data ", allUsers);
        return new ResponseEntity<>(apiResponse, OK);
    }

    @DeleteMapping("/deleteuser/{username}")
    @Operation(
            tags = {"User"},
            operationId = "deletelUser",
            summary = "delete user by Username",
            description = "to delete user data",
            parameters = {
                    @Parameter(name = "username", description = "this is username. should be found",
                            example = "andrew",schema = @Schema(type = "String"))},
            responses = {@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    content = @Content(
                            schema = @Schema(implementation = ApiResponse.class),mediaType = MediaType.APPLICATION_JSON_VALUE),
                    description = "Success Response."),
            }

    )
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable(name = "username") String username){
        Users users = userService.deleteUser(username);
        ApiResponse apiResponse = new ApiResponse(TRUE, "successfully delete user data with username " + username);
        return new ResponseEntity<>(apiResponse, OK);
    }

    @PostMapping("/updateuser/{username}")
    @Operation(
            tags = {"User"},
            operationId = "updateUser",
            summary = "update user data",
            description = "to update user data. username required as path of endpoint",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "This is the request body for update User request.",
                    content = @Content(schema = @Schema(implementation = Users.class))),
            parameters = {
                    @Parameter(name = "username", description = "this is username. should be unique",
                            example = "andrew",schema = @Schema(type = "String"))},
            responses = {@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    content = @Content(
                            schema = @Schema(implementation = Users.class, type = "String"),mediaType = MediaType.APPLICATION_JSON_VALUE),
                    description = "Success Response."),
            }

    )
    public ResponseEntity<ApiResponse> updateUser(@RequestBody UserDTO newUsers, @PathVariable(name = "username") String username){
        Users updatedUsers = userService.updateUser(newUsers, username);
        ApiResponse apiResponse = new ApiResponse(TRUE, "successfully updated user data with username " + username);
        return new ResponseEntity<>(apiResponse, OK);
    }

}
