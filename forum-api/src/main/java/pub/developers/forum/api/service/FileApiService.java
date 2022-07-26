package pub.developers.forum.api.service;

import pub.developers.forum.api.model.ResultModel;
import pub.developers.forum.api.request.file.FileUploadImgRequest;

public interface FileApiService {

    ResultModel<String> uploadImg(FileUploadImgRequest request);

}
