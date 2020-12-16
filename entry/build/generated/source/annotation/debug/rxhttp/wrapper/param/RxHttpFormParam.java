package rxhttp.wrapper.param;

import android.content.Context;
import android.net.Uri;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody.Part;
import okhttp3.RequestBody;
import rxhttp.wrapper.annotations.NonNull;
import rxhttp.wrapper.annotations.Nullable;
import rxhttp.wrapper.entity.UpFile;
import rxhttp.wrapper.param.FormParam;
import rxhttp.wrapper.utils.UriUtil;

/**
 * Github
 * https://github.com/liujingxing/RxHttp
 * https://github.com/liujingxing/RxLife
 * https://github.com/liujingxing/okhttp-RxHttp/wiki/FAQ
 * https://github.com/liujingxing/okhttp-RxHttp/wiki/更新日志
 */
public class RxHttpFormParam extends RxHttpAbstractBodyParam<FormParam, RxHttpFormParam> {
    public RxHttpFormParam(FormParam param) {
        super(param);
    }

    public RxHttpFormParam add(String key, Object value) {
      param.add(key,value);
      return this;
    }
    
    public RxHttpFormParam add(String key, Object value, boolean isAdd) {
      if(isAdd) {
        param.add(key,value);
      }
      return this;
    }
    
    public RxHttpFormParam addAll(Map<String, ?> map) {
      param.addAll(map);
      return this;
    }
    
    public RxHttpFormParam addEncoded(String key, Object value) {
        param.addEncoded(key, value);
        return this;
    }
    
    public RxHttpFormParam addAllEncoded(@NonNull Map<String, ?> map) {
        param.addAllEncoded(map);
        return this;
    }

    public RxHttpFormParam removeAllBody() {
        param.removeAllBody();
        return this;
    }

    public RxHttpFormParam removeAllBody(String key) {
        param.removeAllBody(key);
        return this;
    }

    public RxHttpFormParam set(String key, Object value) {
        param.set(key, value);
        return this;
    }

    public RxHttpFormParam setEncoded(String key, Object value) {
        param.setEncoded(key, value);
        return this;
    }

    /**
     * @deprecated please user {@link #addFile(String, File)} instead
     */
    @Deprecated
    public RxHttpFormParam add(String key, File file) {
        param.addFile(key, file);
        return this;
    }

    public RxHttpFormParam addFile(String key, File file) {
        param.addFile(key, file);
        return this;
    }

    public RxHttpFormParam addFile(String key, String filePath) {
        param.addFile(key, filePath);
        return this;
    }

    public RxHttpFormParam addFile(String key, String filename, String filePath) {
        param.addFile(key, filename, filePath);
        return this;
    }

    public RxHttpFormParam addFile(String key, String filename, File file) {
        param.addFile(key, filename, file);
        return this;
    }

    public RxHttpFormParam addFile(UpFile file) {
        param.addFile(file);
        return this;
    }

    public RxHttpFormParam addFile(String key, List<? extends File> fileList) {
        param.addFile(key, fileList);
        return this;
    }

    public RxHttpFormParam addFile(List<? extends UpFile> fileList) {
        param.addFile(fileList);
        return this;
    }

    public RxHttpFormParam addPart(@Nullable MediaType contentType, byte[] content) {
        param.addPart(contentType, content);
        return this;
    }

    public RxHttpFormParam addPart(@Nullable MediaType contentType, byte[] content, int offset,
                                   int byteCount) {
        param.addPart(contentType, content, offset, byteCount);
        return this;
    }
    
    public RxHttpFormParam addPart(Context context, Uri uri) {
        param.addPart(UriUtil.asRequestBody(uri, context));
        return this;
    }

    public RxHttpFormParam addPart(Context context, String key, Uri uri) {
        param.addPart(UriUtil.asPart(uri, context, key));
        return this;
    }

    public RxHttpFormParam addPart(Context context, String key, String fileName, Uri uri) {
        param.addPart(UriUtil.asPart(uri, context, key, fileName));
        return this;
    }

    public RxHttpFormParam addPart(Context context, Uri uri, @Nullable MediaType contentType) {
        param.addPart(UriUtil.asRequestBody(uri, context, contentType));
        return this;
    }

    public RxHttpFormParam addPart(Context context, String key, Uri uri,
                                   @Nullable MediaType contentType) {
        param.addPart(UriUtil.asPart(uri, context, key, null, contentType));
        return this;
    }

    public RxHttpFormParam addPart(Context context, String key, String filename, Uri uri,
                                   @Nullable MediaType contentType) {
        param.addPart(UriUtil.asPart(uri, context, key, filename, contentType));
        return this;
    }

    public RxHttpFormParam addParts(Context context, Map<String, Uri> uriMap) {
        for (Entry<String, Uri> entry : uriMap.entrySet()) {
            addPart(context, entry.getKey(), entry.getValue());
        }
        return this;
    }

    public RxHttpFormParam addParts(Context context, List<Uri> uris) {
        for (Uri uri : uris) {
            addPart(context, uri);
        }
        return this;
    }

    public RxHttpFormParam addParts(Context context, String key, List<Uri> uris) {
        for (Uri uri : uris) {
            addPart(context, key, uri);
        }
        return this;
    }

    public RxHttpFormParam addParts(Context context, List<Uri> uris,
                                    @Nullable MediaType contentType) {
        for (Uri uri : uris) {
            addPart(context, uri, contentType);
        }
        return this;
    }

    public RxHttpFormParam addParts(Context context, String key, List<Uri> uris,
                                    @Nullable MediaType contentType) {
        for (Uri uri : uris) {
            addPart(context, key, uri, contentType);
        }
        return this;
    }
    
    public RxHttpFormParam addPart(Part part) {
        param.addPart(part);
        return this;
    }

    public RxHttpFormParam addPart(RequestBody requestBody) {
        param.addPart(requestBody);
        return this;
    }

    public RxHttpFormParam addPart(Headers headers, RequestBody requestBody) {
        param.addPart(headers, requestBody);
        return this;
    }

    public RxHttpFormParam addFormDataPart(String key, String fileName, RequestBody requestBody) {
        param.addFormDataPart(key, fileName, requestBody);
        return this;
    }

    public RxHttpFormParam setMultiForm() {
        param.setMultiForm();
        return this;
    }
}
