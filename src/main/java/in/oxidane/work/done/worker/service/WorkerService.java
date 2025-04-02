package in.oxidane.work.done.worker.service;

import in.oxidane.work.done.worker.dto.WorkerRequest;
import in.oxidane.work.done.worker.dto.WorkerResponse;

import java.util.List;

public interface WorkerService {
    WorkerResponse createWorker(WorkerRequest request);

    WorkerResponse getWorkerById(Long id);

    List<WorkerResponse> getAllWorkers();

    WorkerResponse updateWorker(Long id, WorkerRequest request);

    void deleteWorker(Long id);
}
