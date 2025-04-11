package in.oxidane.work.done.worker.service.impl;

import in.oxidane.work.done.common.exception.ResourceNotFoundException;
import in.oxidane.work.done.worker.dao.WorkerDao;
import in.oxidane.work.done.worker.dto.WorkerRequest;
import in.oxidane.work.done.worker.dto.WorkerResponse;
import in.oxidane.work.done.worker.entity.Worker;
import in.oxidane.work.done.worker.mapper.WorkerMapper;
import in.oxidane.work.done.worker.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService {

    private final WorkerDao workerDao;
    private final WorkerMapper workerMapper;

    @Override
    public WorkerResponse createWorker(WorkerRequest request) {
        Worker worker = workerMapper.toEntity(request);
        Worker savedWorker = workerDao.save(worker);
        return workerMapper.toResponse(savedWorker);
    }

    @Override
    public WorkerResponse getWorkerById(Long id) {
        Worker worker = workerDao.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Worker not found with ID: " + id));
        return workerMapper.toResponse(worker);
    }

    @Override
    public List<WorkerResponse> getAllWorkers() {
        List<Worker> workers = workerDao.findAll();
        return workerMapper.toResponse(workers);
    }

    @Override
    public WorkerResponse updateWorker(Long id, WorkerRequest request) {
        Worker existingWorker = workerDao.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Worker not found with ID: " + id));

        Worker updatedWorker = workerMapper.toUpdateEntityFromRequest(request, existingWorker);
        Worker savedWorker = workerDao.save(updatedWorker);

        return workerMapper.toResponse(savedWorker);
    }

    @Override
    public void deleteWorker(Long id) {
        if (!workerDao.existsById(id)) {
            throw new ResourceNotFoundException("Worker not found with ID: " + id);
        }
        workerDao.delete(id);
    }
}
