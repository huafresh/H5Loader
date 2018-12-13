package com.hua.h5loader_core;

import android.text.TextUtils;
import android.util.SparseArray;

/**
 * @author hua
 * @version V1.0
 * @date 2018/12/13 9:42
 */

public class H5LoadManager {
    public static final int h5_ui_container_type_comm = 0;
    public static final int h5_ui_container_type_bar = 1;
    public static final int h5_ui_container_type_progress = 2;
    private IWebViewPool loaderPool;
    private SparseArray<IWebContainer> webContainers;

    public static H5LoadManager get() {
        return Holder.S_INSTANCE;
    }

    private static final class Holder {
        private static final H5LoadManager S_INSTANCE = new H5LoadManager();
    }

    private H5LoadManager() {
        loaderPool = new TkH5LoaderPool();
        collectDefaultWebContainer();
    }

    private void collectDefaultWebContainer() {
        webContainers = new SparseArray<>();
        CommWebFragment.addWebContainer(webContainers);
    }

    /**
     * load h5 with specific webContainer type.
     *
     * @param type    webContainer type
     * @param builder use for confirm T type
     * @param <T>     the build type for webContainer
     * @return H5Builder
     */
    @SuppressWarnings("unchecked")
    public <T extends H5Builder> T loadH5(int type, Class<T> builder) {
        IWebContainer<T> iWebContainer = (IWebContainer<T>) webContainers.get(type);
        return iWebContainer.paramBuilder();
    }

    IWebViewPool getWebViewPool() {
        return loaderPool;
    }

    public static class H5Builder {

    }

}
