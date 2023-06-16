package com.example.prakmobile.databinding;

import androidx.databinding.MergedDataBinderMapper;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new com.example.prakmobile.databinding.DataBinderMapperImpl());
  }
}
