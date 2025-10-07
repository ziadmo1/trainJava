package com.trainJava.demo.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedRes<T> {

    private List<T> data;
    private int currentPage;
    private int totalPages;
    private long totalItems;

}
