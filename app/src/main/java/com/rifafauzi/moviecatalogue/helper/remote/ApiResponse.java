package com.rifafauzi.moviecatalogue.helper.remote;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.rifafauzi.moviecatalogue.model.Movies;

import java.util.List;

import static com.rifafauzi.moviecatalogue.helper.remote.StatusResponse.EMPTY;
import static com.rifafauzi.moviecatalogue.helper.remote.StatusResponse.ERROR;
import static com.rifafauzi.moviecatalogue.helper.remote.StatusResponse.SUCCESS;

public class ApiResponse<T> {

    @NonNull
    public final StatusResponse status;

    @Nullable
    public final String message;

    @Nullable
    public final T body;

    public ApiResponse(@NonNull StatusResponse status, @Nullable T body, @Nullable String message) {
        this.status = status;
        this.body = body;
        this.message = message;
    }

    public static <T> ApiResponse<T> success(@Nullable T body) {
        return new ApiResponse<>(SUCCESS, body, null);
    }

    public static <T> ApiResponse<T> empty(String msg, @Nullable T body) {
        return new ApiResponse<>(EMPTY, body, msg);
    }

    public static <T> ApiResponse<T> error(String msg, @Nullable T body) {
        return new ApiResponse<>(ERROR, body, msg);
    }
}