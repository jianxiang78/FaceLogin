import React, {useEffect} from 'react'
import {
  CButton,
  CCard,
  CCardBody,
  CCardGroup,
  CCol,
  CContainer,
  CRow,
} from '@coreui/react'

import dataService from "../../../tool/dataService";


const Login = () => {

  const handleLogin = (postData,targetUrl) => {
    console.log('Printing postData=', postData);
    console.log('Printing targetUrl=', targetUrl);
    dataService.exeJson(targetUrl,postData)
        .then(response => {
          console.log('response successfully', response.data);
          initLogin(response.data)
        })
        .catch(error => {
          console.log('Something wrong', error);
        })
  }

  const initLogin=(data)=>{
    if(data.code===1){
      dataService.setAuthorization(data.data.Authorization)
      dataService.setLoggedUserName(data.data.userTrueName)
      window.location.href='/'
    }
  }

  const clearLogin=()=>{
    dataService.logout()
  }

  const script = document.createElement('script');
  script.type = 'text/javascript';
  script.async = true;
  script.src = 'https://cdn.faceio.net/fio.js';
  document.head.appendChild(script);

  let myFaceIO;

  useEffect(()=>{
    //eslint-disable-next-line
    myFaceIO = new faceIO("fioab497");
    //"fioab497" is the public ID of my app after registration.
    // You need to replace the public ID of your app
  },[])

  const faceSignUp = async ()=>{
    myFaceIO.enroll({
      "locale": "auto"
    }).then(userInfo => {
      console.log("facialId: " + userInfo.facialId)
      console.log(userInfo);
      handleLogin(userInfo,"login/signUp");
    }).catch(errCode => {
      console.log(errCode);
    })
  }


  const faceSignIn = async ()=>{
    myFaceIO.authenticate({
      "locale": "auto"
    }).then(userInfo => {
      console.log("facialId: " + userInfo.facialId)
      console.log(userInfo);
      handleLogin(userInfo,"login/signIn");
    }).catch(errCode => {
      console.log(errCode);
    })
  }

  return (
    <div className="bg-light min-vh-100 d-flex flex-row align-items-center">
      <CContainer>
        <CRow className="justify-content-center">
          <CCol md={8}>
            <CCardGroup>
              <CCard className="p-4">
                <CCardBody>
                    <h1>Web App Login</h1>
                    <p className="text-medium-emphasis">From Face AI</p>
                    <CRow>
                      <CCol xs={6} className="text-right">
                        <CButton color="primary" className="px-4 text-right" onClick={faceSignIn}>
                          Sign In
                        </CButton>
                      </CCol>
                      <CCol xs={6} className="text-right">
                        <CButton color="primary" className="px-4 text-right" onClick={faceSignUp}>
                          Sign Up
                        </CButton>
                      </CCol>
                    </CRow>
                </CCardBody>
              </CCard>
              <CCard className="text-white bg-primary py-5">
                <CCardBody className="text-center">
                  <div>
                    <h2>Face Login</h2>
                    <h2>Automatic login using AI for face recognition</h2>
                  </div>
                </CCardBody>
              </CCard>
            </CCardGroup>
          </CCol>
        </CRow>
      </CContainer>
      {clearLogin()}
    </div>
  )
}

export default Login
