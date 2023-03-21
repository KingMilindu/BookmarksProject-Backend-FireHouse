package com.app.test.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class bookmarkDTO {
        private int id;
        private String name;
        private String url;
        private String description;
        private String status;
        private String expiry_date;
        private String  featured;
        private String   user_id;
        private String   image;
        private String   created_at;
    }

