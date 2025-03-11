import React, { useContext } from 'react'
import { Button, Container, Flex, FormControl, FormLabel, Heading, Image, Input, Stack, Text, useBreakpointValue, useToast, VStack } from '@chakra-ui/react'
import {useFormik} from 'formik'
import AuthContext from '../context/AuthContext'
import AuthService from '../services/AuthService'
import { useNavigate } from 'react-router-dom'
import svg from '../svgs/main.svg'


function Login() {

    const {login} = useContext(AuthContext)
    const authService = new AuthService()
    const navigate = useNavigate()
    const toast = useToast()

    const formik = useFormik({
      initialValues:{
        email:"",
        password:""
      },
      onSubmit:async(values)=>{
        try{
         const result = await authService.login(values)
         console.log(result.data)
         login(result.data)
         toast({
            title:"Login Succesfully",
            status: 'success',
            duration: 9000,
            isClosable: true,
          })
         navigate("/home")
        }catch(e){
          console.log(e.message)
        }
      }
    })



  return (
    <Stack direction={'row'} spacing={0} minH={'100vh'}>
      
      <Flex justifyContent={'center'} alignItems={'center'} width={'100%'}>
        <Container>
          <VStack as={'form'} p={10} onSubmit={formik.handleSubmit} borderRadius={'xl'} boxShadow={'2xl'} spacing={5}>
            <Heading>Login</Heading>
            <FormControl>
              <FormLabel>Email address</FormLabel>
              <Input
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}
                value={formik.values.email}
                name='email'
                type='email' />
            </FormControl>
            <FormControl>
              <FormLabel>Password</FormLabel>
              <Input
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}
                value={formik.values.password}
                name='password'
                type='password' />
            </FormControl>
            <Button type='submit' colorScheme={'blue'}>Submit</Button>
          </VStack>
        </Container>
      </Flex>
    </Stack>
  )
}

export default Login