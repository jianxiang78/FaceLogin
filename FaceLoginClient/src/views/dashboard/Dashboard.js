import React, {useCallback, useEffect, useState} from 'react'

import {
  CButton,
  CCard,
  CCardBody,
  CCardHeader,
  CCol, CForm, CFormInput, CInputGroup, CInputGroupText, CModal, CModalBody, CModalFooter, CModalHeader, CModalTitle,
  CRow,
  CTable,
  CTableBody,
  CTableDataCell,
  CTableHead,
  CTableHeaderCell,
  CTableRow,
} from '@coreui/react'
import CIcon from '@coreui/icons-react'
import {
  cilPeople,
} from '@coreui/icons'

import moment from "moment";
import dataService from "../../tool/dataService";

const Dashboard = () => {

  const [editVisible, setEditVisible] = useState(false)
  const [tableExample, setTableExample] = useState([]);
  const [clients, setClients] = useState(0);

  const [userId, setUserId ]= useState()
  const [userNickName, setUserNickName ]= useState('')
  const [userTrueName, setUserTrueName ]= useState('')

  const initData= useCallback(() => {
    function dataPage(resultData) {
      if(resultData.code===1){
        setTableExample(resultData.data.tableExample);
        setClients(resultData.data.clients);
        if(resultData.data.loginUser.first===0){
          setUserId(resultData.data.loginUser.userId);
          setEditVisible(true);
        }
      }
    }
    dataService.exeForm("dashboard/demo")
        .then(response => {
          console.log('Printing demo data', response.data);
          dataPage(response.data)
        })
        .catch(error => {
          console.log('Something went wrong', error);
        })
  }, [])

  useEffect(() => {
    initData();
  }, [initData]);



  const ContentEdit = () => {

    const handleEdit = (event) => {
      event.preventDefault()
      setEditVisible(false)
      const postData ={
        userId:userId,
        userNickName:userNickName,
        userTrueName:userTrueName
      }
      dataService.exeForm("system/user/edit",postData)
          .then(response => {
            console.log('Edit successfully', response.data);
            initData();
          })
          .catch(error => {
            console.log('Edit wrong', error);
          })
    }

    return (
        <>
          <CModal scrollable visible={editVisible} onClose={() => setEditVisible(false)} alignment="center">
            <CModalHeader>
              <CModalTitle>Hi, please improve your information</CModalTitle>
            </CModalHeader>
            <CForm onSubmit={handleEdit}>
              <CModalBody>
                <CInputGroup className="mb-3">
                  <CInputGroupText className="col-sm-4">User Id</CInputGroupText>
                  <CFormInput readOnly value={userId} disabled />
                </CInputGroup>
                <CInputGroup className="mb-3">
                  <CInputGroupText className="col-sm-4">Nick Name</CInputGroupText>
                  <CFormInput required value={userNickName} onChange={event => setUserNickName(event.target.value)}/>
                </CInputGroup>
                <CInputGroup className="mb-3">
                  <CInputGroupText className="col-sm-4">True Name</CInputGroupText>
                  <CFormInput required value={userTrueName} onChange={event => setUserTrueName(event.target.value)}/>
                </CInputGroup>
              </CModalBody>
              <CModalFooter>
                <CButton color="secondary" onClick={() => setEditVisible(false)}>
                  Close
                </CButton>
                <CButton color="primary" type="submit">
                  Save
                </CButton>
              </CModalFooter>
            </CForm>
          </CModal>
        </>
    )
  }


  return (
      <>
        <CRow>
          <CCol xs>
            <CCard className="mb-4">
              <CCardHeader>System Information</CCardHeader>
              <CCardBody>
                <CRow>
                  <CCol xs={12} md={6} xl={6}>
                    <CRow>
                      <CCol sm={6}>
                        <div className="border-start border-start-4 border-start-info py-1 px-3">
                          <div className="text-medium-emphasis small">Clients</div>
                          <div className="fs-5 fw-semibold">{clients}</div>
                        </div>
                      </CCol>
                      <CCol sm={6}>
                        <div className="border-start border-start-4 border-start-danger py-1 px-3 mb-3">
                          <div className="text-medium-emphasis small">Recurring Clients</div>
                          <div className="fs-5 fw-semibold">0</div>
                        </div>
                      </CCol>
                    </CRow>
                  </CCol>

                  <CCol xs={12} md={6} xl={6}>
                    <CRow>
                      <CCol sm={6}>
                        <div className="border-start border-start-4 border-start-warning py-1 px-3 mb-3">
                          <div className="text-medium-emphasis small">Pageviews</div>
                          <div className="fs-5 fw-semibold">0</div>
                        </div>
                      </CCol>
                      <CCol sm={6}>
                        <div className="border-start border-start-4 border-start-success py-1 px-3 mb-3">
                          <div className="text-medium-emphasis small">Organic</div>
                          <div className="fs-5 fw-semibold">0</div>
                        </div>
                      </CCol>
                    </CRow>
                  </CCol>
                </CRow>

                <br />

                <CTable align="middle" className="mb-0 border" hover responsive>
                  <CTableHead color="light">
                    <CTableRow>
                      <CTableHeaderCell className="text-center">
                        <CIcon icon={cilPeople} />
                      </CTableHeaderCell>
                      <CTableHeaderCell>User ID</CTableHeaderCell>
                      <CTableHeaderCell>Facial Id</CTableHeaderCell>
                      <CTableHeaderCell>Nick Name</CTableHeaderCell>
                      <CTableHeaderCell>True Name</CTableHeaderCell>
                      <CTableHeaderCell>Age</CTableHeaderCell>
                      <CTableHeaderCell>Gender</CTableHeaderCell>
                      <CTableHeaderCell>Reg Time</CTableHeaderCell>
                      <CTableHeaderCell>Last Login Time</CTableHeaderCell>
                    </CTableRow>
                  </CTableHead>
                  <CTableBody>
                    {tableExample.map((item, index) => (
                        <CTableRow v-for="item in tableItems" key={index}>
                          <CTableDataCell className="text-center">
                          </CTableDataCell>
                          <CTableDataCell>
                            {item.userId}
                          </CTableDataCell>
                          <CTableDataCell>
                            {item.facialId}
                          </CTableDataCell>
                          <CTableDataCell>
                            {item.userNickName}
                          </CTableDataCell>
                          <CTableDataCell>
                            {item.userTrueName}
                          </CTableDataCell>
                          <CTableDataCell>
                            {item.userAge}
                          </CTableDataCell>
                          <CTableDataCell>
                            {item.userGender}
                          </CTableDataCell>
                          <CTableDataCell>
                            {moment(item.regTime).format("yyyy-MM-DD HH:mm:ss")}
                          </CTableDataCell>
                          <CTableDataCell>
                            {moment(item.lastLoginTime).format("yyyy-MM-DD HH:mm:ss")}
                          </CTableDataCell>
                        </CTableRow>
                    ))}
                  </CTableBody>
                </CTable>
              </CCardBody>
            </CCard>
          </CCol>
        </CRow>
        {ContentEdit()}
      </>
  )
}

export default Dashboard
