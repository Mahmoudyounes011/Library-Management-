package com.Damascus.Library.dto.response;

import com.Damascus.Library.model.entity.Patron;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatronResponse {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private Boolean active = true;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static  PatronResponse fromEntity(Patron patron) {
        return PatronResponse.builder()
                .id(patron.getId())
                .name(patron.getName())
                .email(patron.getEmail())
                .phoneNumber(patron.getPhoneNumber())
                .active(patron.getActive())
                .createdAt(patron.getCreatedAt())
                .updatedAt(patron.getUpdatedAt())
                .build();
    }
}
