import React from 'react'
import CIcon from '@coreui/icons-react'
import {
    cilSpeedometer,
} from '@coreui/icons'
import { CNavItem} from '@coreui/react'

const menu_nav=[
    {
        component: CNavItem,
        name: 'Dashboard',
        to: '/dashboard',
        icon: <CIcon icon={cilSpeedometer} customClassName="nav-icon" />,
    }
]


export default menu_nav
