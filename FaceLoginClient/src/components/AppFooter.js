import React from 'react'
import { CFooter } from '@coreui/react'

const AppFooter = () => {
  return (
    <CFooter>
      <div>
        <span className="ms-1">Face Login &copy; 2023 Auto17.com</span>
      </div>
      <div className="ms-auto">
        <span className="me-1">Powered by FACEIO, React, CoreUI &amp; SpringBoot</span>
      </div>
    </CFooter>
  )
}

export default React.memo(AppFooter)
