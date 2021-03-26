export class Product {

    // User model.
    productName!: string;
    productType!: string;
    productDescription!: string;
    initialBiddingAmount!: number;
    lastBiddedAmount!: number;
    // isSeller:boolean

    // Mapping of User model(above) with the User moldel of Database or the REST API.
    // constructor(userResponse: any) {
    //     this.productName = userResponse.productName;
    //     this.productType = userResponse.productType;
    //     this.productDescription = userResponse.productDescription;
    //     this.initialBiddingAmount = userResponse.initialBiddingAmount;
    //     this.lastBiddedAmount = userResponse.lastBiddedAmount;
    // }

    constructor() {
    }
}
