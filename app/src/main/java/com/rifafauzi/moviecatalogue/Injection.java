package com.rifafauzi.moviecatalogue;

import com.rifafauzi.moviecatalogue.data.Repository;
import com.rifafauzi.moviecatalogue.data.remote.RemoteDataSource;

public class Injection {

    public static Repository repository() {
        return new Repository(new RemoteDataSource());
    }

}
