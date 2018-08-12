package com.piotrslowinski.sales.application;

import com.piotrslowinski.sales.domain.users.UserDto;

public interface UserFinder {

    UserDto getUserDetails(Long userId);
}
