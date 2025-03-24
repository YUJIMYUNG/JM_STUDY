package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.repository.RecordRepository;

@Service
public class RecordService {
    @Autowired
    private RecordRepository recordRepository;
}

