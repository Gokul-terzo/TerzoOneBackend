package com.terzoOne.terzoOneBackend.service.impl;

import com.terzoOne.terzoOneBackend.models.Employee;
import com.terzoOne.terzoOneBackend.models.Leaves;
import com.terzoOne.terzoOneBackend.repository.LeavesRepository;
import com.terzoOne.terzoOneBackend.service.LeavesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LeavesServiceImpl implements LeavesService {
    private final LeavesRepository leavesRepository;


    @Override
    public void saveLeaves(Leaves leaves) {
        leavesRepository.save(leaves);
    }
}
