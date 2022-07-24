/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.0.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.service.user.api;

import com.service.user.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import javax.validation.Valid;

import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-10T10:41:55.316283+07:00[Asia/Ho_Chi_Minh]")
@Validated
@Tag(name = "users", description = "the users API")
public interface UsersApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /users : Add a new user
     * 
     *
     * @param user  (required)
     * @return successful created (status code 201)
     *         or bad request (status code 400)
     */
    @Operation(
        operationId = "addUser",
        summary = "Add a new user",
        responses = {
            @ApiResponse(responseCode = "201", description = "successful created", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))
            }),
            @ApiResponse(responseCode = "400", description = "bad request")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<User> addUser(
        @Parameter(name = "User", description = "", required = true) @RequestBody User user
    ) {
        var request = getRequest().orElse(null);
        System.out.println("addUser in interface");
        if (request != null) {
            final var returnUser = doAddUser(user);
            return new ResponseEntity<>(returnUser, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    User doAddUser(@Valid User user);

    /**
     * DELETE /users/{username} : Delete a user by username
     * 
     *
     * @param username username of user to Returns (required)
     * @return successful operation (status code 204)
     *         or invalid username (status code 400)
     *         or user not found (status code 404)
     */
    @Operation(
        operationId = "deleteUser",
        summary = "Delete a user by username",
        responses = {
            @ApiResponse(responseCode = "204", description = "successful operation"),
            @ApiResponse(responseCode = "400", description = "invalid username"),
            @ApiResponse(responseCode = "404", description = "user not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/{username}"
    )
    default ResponseEntity<Void> deleteUser(
        @Parameter(name = "username", description = "username of user to Returns", required = true) @PathVariable("username") String username
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /users/{username} : Get a user by user name
     * Returns a user
     *
     * @param username username of user to Returns (required)
     * @return successful operation (status code 200)
     *         or invalid username (status code 400)
     *         or user not found (status code 404)
     */
    @Operation(
        operationId = "getUserByUsername",
        summary = "Get a user by user name",
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))
            }),
            @ApiResponse(responseCode = "400", description = "invalid username"),
            @ApiResponse(responseCode = "404", description = "user not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/{username}",
        produces = { "application/json" }
    )
    default ResponseEntity<User> getUserByUsername(
        @Parameter(name = "username", description = "username of user to Returns", required = true) @PathVariable("username") String username
    ) {
        var request = getRequest().orElse(null);
        if (request != null)
            return new ResponseEntity<>(doGetUserByUserName(username), HttpStatus.OK);
        
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    User doGetUserByUserName(String username);

    /**
     * GET /users : List all users
     * 
     *
     * @return successful operation (status code 200)
     */
    @Operation(
        operationId = "listUsers",
        summary = "List all users",
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = User.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        produces = { "application/json" }
    )
    default ResponseEntity<List<User>> listUsers(
        
    ) {
        var request = getRequest().orElse(null);
        if (request != null)
            return new ResponseEntity<>(doListUsers(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    List<User> doListUsers();

}
