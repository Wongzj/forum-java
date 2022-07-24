import axios from 'axios'
import iView from 'iview'
// import Vue from 'vue'

// axios default configuration
axios.defaults.timeout = 100000 //overtime time
axios.defaults.baseURL = '' // The default is the current access address, which is used when deploying to the server
if (location.href.includes('127.0.0.1') || location.href.includes('localhost')) {
  axios.defaults.baseURL = 'http://localhost:8080' // Local forum-java application service address
}

// axios.defaults.transformRequest = function (data) {
//   // data = Qs.stringify(data);
//   data = JSON.stringify(data)
//   return data
// }

// axios.defaults.headers['Content-Type'] = 'application/json;charset=UTF-8'
// axios.defaults.headers['token'] = localStorage.getItem('token')

// Routing request interception
// http request
axios.interceptors.request.use(
  config => {
    if (config.headers['Content-Type'] !== 'multipart/form-data') {
      config.headers['Content-Type'] = 'application/json;charset=UTF-8'
    }
    // config.data = JSON.stringify(config.data) '19a9390e08b44b49926003e3bc866950'
    config.headers.token = localStorage.getItem('token')
    return config
  },
  error => {
    return Promise.reject(error.response)
  }
)

// Route response interception
// http response 
axios.interceptors.response.use(
  response => {
    // console.info('response info ===>', response) 80008998
    if (response.data.code === 80008998) {
      iView.Message.error(response.data.message)
      window.location.href = window.location.origin + '/?toast=' + response.data.message
    }
    return response.data
  },
  error => {
    return Promise.reject(error.response) //Returns the error information returned by the interface
  }
)

export default axios
