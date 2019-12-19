import { CustomerWalletDTO } from './customer-wallet-dto';
import { Account } from '../account';

export class CustomerDTO {
    id: number;
    userToken: String;
    typeRegister: number;
    userType: number;
    account: Account;
    customerWalletDTO: CustomerWalletDTO
}
